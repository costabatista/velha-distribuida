/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velha;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import velha.jogador.Jogador;

/**
 *
 * @author paulo
 */
public class Velha extends Thread{
    private static HashMap<Jogador, DataOutputStream> links;
    private final Socket socket;
    private static int contador;
    
    public Velha(Socket socket) {
        this.socket = socket;
    }
    
    
    
    public void avisarEntradaDeNovoJogador(Jogador jogador) {
        Iterator iterator = links.entrySet().iterator();
        
        while(iterator.hasNext()) {
            Map.Entry par = (Map.Entry)iterator.next();
            DataOutputStream out = (DataOutputStream)par.getValue();
            String mensagem = "|Entrou|" + jogador.getNome() + "|" + jogador.getId();
            try {
                out.writeUTF(mensagem);
            } catch(IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            
        }
    }
    
    @Override
    public void run() {
        String message;
        try {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream output = new DataOutputStream(outputStream);
            InputStream inputStream = socket.getInputStream();
            DataInputStream input = new DataInputStream(inputStream);
            
            String nome = input.readUTF();
            Jogador jogador = new Jogador(nome, contador);
            
            links.put(jogador, output);
            
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 6666;
        ServerSocket serverSocket;
        boolean execute = true;
        Velha velha;
        links = new HashMap<>();
        contador = 1;
        try {
            serverSocket = new ServerSocket(port);
            
            while(execute) {
                Socket socket = serverSocket.accept();
                velha = new Velha(socket);
                contador++;
                velha.start();
            }
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
}
