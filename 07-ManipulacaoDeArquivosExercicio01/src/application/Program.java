package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class Program {

	public static void main(String[] args) {

		List<Produto> lista = new ArrayList<>();

		String inPath = "C:\\Users\\Leonan\\Desktop\\Dio\\ProjetoGit\\EstudosJava\\07-ManipulacaoDeArquivosExercicio01\\in\\";
		String outPath = "C:\\Users\\Leonan\\Desktop\\Dio\\ProjetoGit\\EstudosJava\\07-ManipulacaoDeArquivosExercicio01\\out\\";

		File newInFile = new File(inPath + "in.csv");
		File newOutFile = new File(outPath + "out.csv");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(newOutFile));
				BufferedReader br = new BufferedReader(new FileReader(newInFile))) {

			while (br.ready()) {
				String tmp;

				tmp = br.readLine();

				String[] str = tmp.split(",");

				lista.add(new Produto(str[0], Double.parseDouble(str[1]), Integer.parseInt(str[2])));
			}

			for (Produto produto : lista) {
				bw.write(produto.toString());
				bw.newLine();
				System.out.println(produto);
			}

		} catch (IOException e) {
			e.getStackTrace();
		}

	}
}
