<template>
    <main>
    <div>
        <ul v-if="produtos.length > 0">
            <li v-for="produto in produtos" :key="produto.id">
            {{ produto.nome }} - {{ produto.preco }} - {{ produto.quantidade }}
            </li>
        </ul>
        <div v-else> 
            Nenhum produto encontrado.
        </div>

        <form action="post">
          
        </form>
    </div>
    </main>
   
  </template>
  
  <script>
  import api from '../services/api';
  
  export default {
    name: 'Teste',
    data() {
      return {
        produtos: []
      };
    },
    mounted() {
      this.getProdutos();
    },
    methods: {
      getProdutos() {
        api.get('/api/produtos')
          .then(response => {
            console.log(response.data);
            this.produtos = response.data;
          })
          .catch(error => {
            console.error('Erro ao buscar produtos:', error);
          });
      },
  
      // Implemente as funções para as outras ações CRUD (create, update, delete) conforme necessário.
    },
  };
  </script>
  