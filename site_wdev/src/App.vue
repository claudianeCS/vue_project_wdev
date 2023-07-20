<script>

import './style/global.css';
import Header from './components/Header.vue';
import Home from './pages/Home.vue';
import Footer from './components/Footer.vue';

export default{
  name: 'App',
  components:{
    Header,
    Home,
    Footer
  }
}

</script>

<template>
  <div >
    <Header/>
    <Home/>
    <Footer/>
  </div>

</template>
