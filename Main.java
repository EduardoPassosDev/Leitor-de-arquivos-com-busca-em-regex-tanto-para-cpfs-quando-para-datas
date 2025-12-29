import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String conteudo = obterConteudoDoArquivo("lista.txt");
        ArrayList<String> datas = obterDatasDoTexto(conteudo);
        System.out.println(datas);


    }

    public static ArrayList<String> obterCpfsDoTexto(String texto){

        ArrayList<String> cpfs = new ArrayList<>();

        Pattern pattern  = Pattern.compile("(([0-9]{3}[\\.|\\-]){3}([0-9]){2})");
        Matcher matcher = pattern.matcher(texto);

        while(matcher.find()){
            cpfs.add(matcher.group());
        }

        return cpfs;

    }

    public static ArrayList<String> obterDatasDoTexto(String texto){

        ArrayList<String> datas = new ArrayList<>();

        Pattern pattern = Pattern.compile("(([0-9]{2}[\\-]){2}([0-9]){2})");
        Matcher matcher = pattern.matcher(texto);

        while(matcher.find()){
            datas.add(matcher.group());
        }

        return datas;
    }

    public static String obterConteudoDoArquivo (String caminhoParaOArquivo){

        String conteudo = "";

        try {
            FileReader reader = new FileReader(caminhoParaOArquivo);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while(line != null){
                conteudo = conteudo.concat(line.concat("\n"));
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo informado não existe!");
        } catch (IOException e) {
            System.out.println("Ocorreu um problema: " + e.getMessage());
        }
        return conteudo;
    }
}
