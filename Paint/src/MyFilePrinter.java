import java.io.*;

public class MyFilePrinter {

    public MyFilePrinter(Grid grid) {
        this.grid = grid;
    }

    Grid grid;

    //Reads save.txt and changes the arrayFileTxt of the grid.
    public void loadFile(String file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fileReader);

        for (int i = 0; i < grid.getRows(); i++) {
            String line = "";
            if ((line = bReader.readLine()) != null){
                String[] lineChars = line.split("");

            for (int j = 0; j < lineChars.length; j++) {
                grid.setArrayFileTxt(j, i, lineChars[j]);

                }
            }
        }
    }


    //Saves the String saved on save() and writes it into the save.txt
    private void writeFile(String file, String fileTxt) throws IOException {

        FileWriter writer = new FileWriter(file);

        BufferedWriter bWriter = new BufferedWriter(writer);

        bWriter.write(fileTxt);
        bWriter.flush();
        bWriter.close();
        System.out.println("Saved file");

    }

    //Reads the ArrayFileTxt of the Grid and turns it into a String
    public void save() throws IOException {
        String saveLine = "";
        String fileTxt = "";
        for(int i = 0; i < grid.getCols(); i++){
            for(int j = 0; j < grid.getRows(); j++){
                String character = grid.getArrayFileTxt(i,j);
                if(j == 0){
                    saveLine = character;
                }else {
                    saveLine += character;
                }
            }
            fileTxt += saveLine + "\n";
        }
        writeFile("Resources/save.txt", fileTxt);
    }
}