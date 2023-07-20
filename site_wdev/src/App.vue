<script>

import './style/global.css';
import Header from './components/Header.vue';
import Home from './pages/Home.vue';
import Teste from './pages/Teste.vue';

export default{
  name: 'App',
  components:{
    Header,
    Home,
    Teste
  }
}

</script>

<template>
  <div >
    <Header/>
    <Teste/>
    <Footer/>
  </div>

</template>
