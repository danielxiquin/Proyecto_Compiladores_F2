// Código generado automáticamente
// Fecha: Tue May 20 10:50:34 CST 2025

// Funciones predefinidas
function read(promptText) {
  return prompt(promptText || 'Ingrese un valor:');
}

function write(text) {
  console.log(text);
  if (typeof document !== 'undefined') {
    document.body.innerHTML += text + '<br>';
  }
}

function esPar(n) {
  let resultado = Number(Number(n) % 2);
  let texto = "";
  if (resultado == 0) {
    texto = "es par";
  } else {
    texto = "es impar";
  }
  return texto;
}

function main() {
  let animal = Number(2);
  let numero = Number(animal);
  let resultado2 = esPar(2);
  write(resultado2);
}


// Ejecución automática
if (typeof main === 'function') {
  main();
}
