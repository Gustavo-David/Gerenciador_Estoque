document.addEventListener('DOMContentLoaded', function() {
    const searchForm = document.getElementById('form-consulta');
    const productsList = document.getElementById('products-list');
    const searchResults = document.getElementById('search-results');

    // Função para realizar consulta
    searchForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.getElementById('search-name').value;
        const category = document.getElementById('search-category').value;
        const quantity = document.getElementById('search-quantity').value;

        // Realizar uma requisição ao backend (substituir pela URL real)
        fetch(`/api/products?name=${name}&category=${category}&quantity=${quantity}`)
            .then(response => response.json())
            .then(data => {
                searchResults.innerHTML = '';
                data.forEach(product => {
                    const productDiv = document.createElement('div');
                    productDiv.classList.add('product-item');
                    productDiv.innerHTML = `
                        <h3>${product.name}</h3>
                        <p>Quantidade: ${product.quantity}</p>
                        <p>Preço de Compra: R$ ${product.buyPrice}</p>
                        <p>Preço de Venda: R$ ${product.sellPrice}</p>
                        <p>Categoria: ${product.category.name}</p>
                    `;
                    searchResults.appendChild(productDiv);
                });
            })
            .catch(error => {
                console.error('Erro na consulta', error);
            });
    });
});
