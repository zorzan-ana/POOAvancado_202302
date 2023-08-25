import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHTTP {
    public static void main(String[] args) {
        int port = 80;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor rodando na porta " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                manipulaRequisicao(clientSocket);
            }
        } catch (Exception e) {

        }
    }
    private static void manipulaRequisicao(Socket client) throws IOException {
        OutputStream out = client.getOutputStream();
        String resposta = "HTTP/1.1 200 OK\r\nContent-Length: 12\r\n\r\nHello Wordl!";
        out.write(resposta.getBytes());
        out.close();
        client.close();
    }
}