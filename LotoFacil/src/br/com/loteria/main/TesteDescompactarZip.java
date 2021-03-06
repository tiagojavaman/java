package br.com.loteria.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TesteDescompactarZip {

	public static void main(String[] args) {
		try {
			String arquivo = "/tmp/D_lotfac.zip";
			String diretorio = "/tmp/";
			final int BUFFER = 2048;

			FileInputStream fis = new FileInputStream(arquivo);
			BufferedInputStream bis = new BufferedInputStream(fis, BUFFER);
			ZipInputStream zis = new ZipInputStream(bis);
			ZipEntry entrada = null;
			while ((entrada = zis.getNextEntry()) != null) {
				int bytesLidos = 0;
				byte dados[] = new byte[BUFFER];
				System.out.println("Extraindo arquivo: " + entrada.getName());
				// grava o arquivo em disco
				FileOutputStream fos = new FileOutputStream(diretorio + entrada.getName());
				BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
				while ((bytesLidos = zis.read(dados, 0, BUFFER)) != -1) {
					dest.write(dados, 0, bytesLidos);
				}
				dest.flush();
				dest.close();
				fos.close();
			}
			zis.close();
			bis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// http://www.guj.com.br/articles/181