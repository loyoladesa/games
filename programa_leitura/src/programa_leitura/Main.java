package programa_leitura;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		String nome, idade, peso,cidade,estado,pais;
		System.out.println("Digite o seu nome: ");
		nome = in.nextLine();
		System.out.println("Digite a sua idade: ");
		idade = in.nextLine();
		System.out.println("Digite o seu peso: ");
		peso = in.nextLine();
		System.out.println("Digite a sua cidade: ");
		cidade = in.nextLine();
		System.out.println("Digite o seu estado: ");
		estado = in.nextLine();
		System.out.println("Digite o seu pa�s: ");
		pais = in.nextLine();
		
		//Gerar resultado	
		System.out.println("-----------------");
		System.out.println("Aqui est� o resultado do teste:");
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Peso: "+peso);
		System.out.println("Cidade: "+cidade);
		System.out.println("Estado: "+estado);
		System.out.println("Pa�s: "+pais);
	}
	
	
	
	
}
