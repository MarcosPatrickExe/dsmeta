export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "https://patrick-dsmeta-backend.herokuapp.com/sales";
// 'VITE_BACKEND_URL' É UMA VARIAVEL DE AMBIENTE QUE EH INICIALIZADA PELO SERVIDOR. 
// CASO NAO EXISTA, ENTAO O VALOR "http://localhost:8080" SERÁ ATRIBUÍDO A VARIAVEL GLOBAL "BASE_URL"