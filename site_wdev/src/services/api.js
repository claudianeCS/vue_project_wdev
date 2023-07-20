import axios from "axios";


const api = axios.create({
    baseURL: 'http://localhost:8080/apiTeste'
})

export default api;