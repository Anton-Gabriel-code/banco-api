const API = 'http://localhost:8080/contas';

function mostrar(dados) {
    document.getElementById('resultado').textContent = JSON.stringify(dados, null, 2);
}

async function criarConta() {
    const titular = document.getElementById('titular').value;
    const tipo = document.getElementById('tipo').value;
    const res = await fetch(API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ titular, tipo })
    });
    mostrar(await res.json());
}

async function listarContas() {
    const res = await fetch(API);
    mostrar(await res.json());
}

async function depositar() {
    const id = document.getElementById('idDeposito').value;
    const valor = parseFloat(document.getElementById('valorDeposito').value);
    const res = await fetch(`${API}/depositar`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id, valor })
    });
    mostrar(await res.json());
}

async function sacar() {
    const id = document.getElementById('idSaque').value;
    const valor = parseFloat(document.getElementById('valorSaque').value);
    const res = await fetch(`${API}/sacar`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id, valor })
    });
    mostrar(await res.json());
}

async function transferir() {
    const origemId = document.getElementById('origemId').value;
    const destinoId = document.getElementById('destinoId').value;
    const valor = parseFloat(document.getElementById('valorTransferencia').value);
    const res = await fetch(`${API}/transferir`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ origemId, destinoId, valor })
    });
    mostrar('Transferência realizada com sucesso!');
}

async function calcularTributo() {
    const id = document.getElementById('idTributo').value;
    const res = await fetch(`${API}/tributo/${id}`);
    const valor = await res.json();
    mostrar(`Tributo da conta ${id}: R$ ${valor.toFixed(2)}`);
}