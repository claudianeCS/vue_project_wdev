<template>
    <footer>

    </footer>
</template>
<script>
import api from '../services/api';

export default{
    name: 'Footer',
    data(){
        return{
            socialLinks: []
        }
    },
    mounted(){
        //. get para pegar o method GET com a url que contem os dados, depois adicionamos um response para vizualizar essa resposta no console
        api.get('/social-links.json').then(reponse => {
            console.log(reponse.data)
            this.socialLinks = reponse.data;
        })
    }
}
</script>
<style scoped>
footer{
    width: 100%;
    height: 60px;
    background-color:  var(--color-background-nav);
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>