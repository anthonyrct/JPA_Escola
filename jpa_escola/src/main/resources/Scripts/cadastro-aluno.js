document.getElementById("cadastro-aluno-form").addEventListener("submit", function (event) {
    // Impede o envio padrão do formulário
    event.preventDefault();
    setTimeout(function () {
        document.getElementById("success-message").style.display = "block";
    }, 1000);
})
