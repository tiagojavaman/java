package br.com.loteria.main;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// definição da classe HttpDownload
public class HttpDownload {
	private final HttpClient httpclient;

	public static void main(String[] args) {
		// instanciando e usando a classe HttpDownload
		HttpDownload httpDownload = new HttpDownload(new DefaultHttpClient());

		// fazendo o download e salvando em diretorio local
		httpDownload.downloadByGet("http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_lotfac.zip", "/tmp/D_lotfac.zip");
	}

	// construtor
	public HttpDownload(HttpClient httpclient) {
		this.httpclient = httpclient;
	}

	// método que realiza download de arquivo via método GET
	public void downloadByGet(String URL, String path) {
		HttpGet httpget = new HttpGet(URL);
		try {
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				/* salvar arquivo no disco */
				java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
				entity.writeTo(fos);
				fos.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
