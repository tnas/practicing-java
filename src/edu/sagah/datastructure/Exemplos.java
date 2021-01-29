package edu.sagah.datastructure;

public class Exemplos {

	public static void trocar(int a, int b) {
		int aux = a;
		a = b;
		b = aux;
		System.out.println("[trocar] Depois da troca: a = " + a + " b = " + b);
	}

	public static void main(String[] args) {
		int a = 30;
		int b = 45;
		System.out.println("[main] Antes da troca:, a = " + a + " and b = " + b);
		trocar(a, b);
		System.out.println("[main] Depois da troca: a = " + a + " and b is " + b);

	}

}

class Estudante {

	private int nota;

	public Estudante() {
		nota = 10;
	}

	public void definirNota(int num) {
		nota = num;
	}

	public void imprimirNota() {
		System.out.println("O valor da sua nota é: " + nota);
	}

	public static void main(String[] args) {
		Estudante estudante = new Estudante();
		estudante.imprimirNota();
		estudante.definirNota(30);
		estudante.imprimirNota();
	}
}

class Sentenca {

	public static void main(String[] args) {

		String palavra = "Modularizacao em Java";
		int cont = 0;

		for (int i = 0; i < palavra.length(); i++) {
			if (ehVogal(palavra.charAt(i))) {
				cont++;
			}
		}

		System.out.println(cont);
	}

	public static boolean ehVogal(char letra) {
		switch (letra) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			return true;
		default:
			return false;
		}
	}
}

class NumeroPrimo {

	public static void main(String[] args) {

		int numero = 10;
		boolean ehPrimo = true;

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				ehPrimo = false;
				break;
			}
		}

		if (ehPrimo)
			System.out.println(numero + " é primo");
		else
			System.out.println(numero + " não é primo");

		numero = 11;
		ehPrimo = true;

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				ehPrimo = false;
				break;
			}
		}

		if (ehPrimo)
			System.out.println(numero + " é primo");
		else
			System.out.println(numero + " não é primo");
	}

	public static boolean ehPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}

		return true;
	}
}

class Digito {

	public static void main(String[] args) {
		int digitos = 1111111111;
		System.out.println("A soma dos dígitos é: " + somaDigitos(digitos));
		Digito dig = new Digito();
		System.out.println("A soma dos dígitos é: " + dig.somaDigitos(digitos));
	}

	public int somaDigitosInstancia(long n) {

		int valor = 0;
		while (n > 0) {
			valor += n % 10;
			n /= 10;
		}
		return valor;

	}

	public static int somaDigitos(long n) {

		int valor = 0;

		while (n > 0) {
			valor += n % 10;
			n /= 10;
		}

		return valor;
	}

}

class AnoBissexto {

	public static void main(String[] args) {
		AnoBissexto bissexto = new AnoBissexto();
		int ano = 2017;
		System.out.println(bissexto.ehBissexto(ano));
	}

	public boolean ehBissexto(int ano) {
		boolean a = (ano % 4) == 0;
		boolean b = (ano % 100) != 0;
		boolean c = ((ano % 100 == 0) && (ano % 400 == 0));

		return a && (b || c);
	}
}

class ValidadorSenha {

	public static final int TAMANHO_SENHA = 8;

	public static void main(String[] args) {
		String s = "abcdef12";
		if (ehSenhaValida(s)) {
			System.out.println("Senha é valida: " + s);
		} else {
			System.out.println("Senha inválida: " + s);
		}
	}

	public static boolean ehSenhaValida(String senha) {
		if (senha.length() < TAMANHO_SENHA)
			return false;
		int contaCaracteres = 0;
		int numContador = 0;
		for (int i = 0; i < senha.length(); i++) {	
			char ch = senha.charAt(i);
			if (ehNumerico(ch))
				numContador++;
			else if (ehLetra(ch))
				contaCaracteres++;
			else
				return false;
		}
		return (contaCaracteres >= 2 && numContador >= 2);
	}

	public static boolean ehLetra(char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
	}

	public static boolean ehNumerico(char ch) {
		return (ch >= '0' && ch <= '9');
	}

}
