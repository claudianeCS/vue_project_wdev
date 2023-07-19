<template>
    <header>
        <nav class="container">
            <a href="/"><img src="https://raw.githubusercontent.com/william-costa/wdev-mock-site-resources/master/assets/images/wdev.svg" alt="w_dev" id="logo"></a>
            <img id="menu-button" v-on:click="openMenu" src="https://raw.githubusercontent.com/william-costa/wdev-mock-site-resources/master/assets/images/menu.svg" alt="abrir_menu">
            <div id="menu-overlay" v-if="menuActive"></div>
            <div id="menu-itens" :class="{active:menuActive}" v-on:click="closeMenu">
                <img src="https://raw.githubusercontent.com/william-costa/wdev-mock-site-resources/master/assets/images/wdev.svg" alt="w_dev" id="menu-logo">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/videos">Video</a></li>
                    <li><a href="/sobre">Sobre</a></li>
                    <li><a href="/contato">Contato</a></li>
                </ul>
            </div> 
        </nav>
    </header>
</template>
<script>
export default{
    name: 'Header',
    data(){
        return{
            menuActive: false
        }
    },
    methods:{
        openMenu: function(){
            this.menuActive = !this.menuActive;

        },
        closeMenu: function(){
            this.menuActive = false;
        }
    }
    

    // o style scoped restringe toda a alteração de css a esse componente somente
}
</script>
<style scoped>
header{
    background-color: var(--color-background-nav);
    width: 100%;
    height: 65px;
    display: flex;
    justify-content: center;
    align-items: center;
}
nav{
    display: flex;
    justify-content: space-between;
}
#logo{
    width: 120px;
}
#menu-button{
    width: 30px;
}
#menu-overlay{
    position: fixed;
    top: 0;
    left: 0;
    width: 45%;
    height: 100vh;
    background-color: #000;
    opacity: 0.8;
}
#menu-logo{
    width: 110px;
    margin-top: 35px;
    margin-bottom: 15px;
}
#menu-itens{
    position: fixed;
    top: 0;
    right: 0;
    background-color: var(--color-background-nav);
    width: 55%;
    height: 100vh;
    display: none;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
}
#menu-itens.active{
    display: flex
}
ul{
    list-style: none;
    text-align: center;
}
ul li{
    margin: 20px 0;
}
ul li a{
    color: var(--color-text-light)
}
</style>