import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {
    public static void main(String[] args) {
        int port = 80;
        try {
            // Instancia um novo objeto ServerSocket o qual já abre a porta TCP definida
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server rodando na porta " + port);
            while (true) { // loop para receber várias conexões, não somente uma
                /*
                 * Aguarda uma requisição (request),
                 * ao receber é criado um novo thread para lidar com a solicitação
                 */
                Socket clienSocket = serverSocket.accept();
                handleRequest(clienSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        /*
         * InputStreamReader = Converte os dados brutos em caracteres
         * BufferedReader = Fornece buffering para melhorar o desempenho na leitura
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        /* Declara a variável apontando para o response da solicitação */
        OutputStream out = clientSocket.getOutputStream();
        String requestLine = in.readLine();
        String response = "";
        if (requestLine != null) {
            System.out.println("Received request: " + requestLine);
            if (requestLine.startsWith("GET")) {
                // Send a basic HTTP response
                response = "HTTP/1.1 200 OK\r\nContent-Length: 12\r\n\r\nHello Wordl!";
            } else if (requestLine.startsWith("POST")) {
                // Read the content length from headers
                String contentLengthHeader = findHeader(in, "Content-Length");
                int contentLength = Integer.parseInt(contentLengthHeader) + 1;

                // Read the POST data from the body
                char[] postData = new char[contentLength];
                in.read(postData);

                String postDataStr = new String(postData);
                System.out.println("Received POST data: " + postDataStr);

                // Manually parse JSON data
                String jsonField = "name";
                int fieldIndex = postDataStr.indexOf(jsonField);
                if (fieldIndex != -1) {
                    int valueStartIndex = postDataStr.indexOf(":", fieldIndex) + 3;  // Adding 2 to skip : "
                    int valueEndIndex = postDataStr.indexOf("\"", valueStartIndex);
                    String value = postDataStr.substring(valueStartIndex, valueEndIndex);
                    System.out.println("Received name: " + value);
                }
                
                // Send a response for POST request
                response = "HTTP/1.1 200 OK\r\nContent-Length: 30\r\n\r\nRecebi seus dados!";
            } else {
                response = "HTTP/1.1 405 Method Not Allowed\r\n\r\n";
            }
            out.write(response.getBytes());
        }
        out.close();
        in.close();
        clientSocket.close();
    }

    private static String findHeader(BufferedReader reader, String headerName) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            if (line.startsWith(headerName)) {
                String[] parts = line.split(": ");
                if (parts.length > 1) {
                    return parts[1];
                }
            }
        }
        return null;
    }
}
