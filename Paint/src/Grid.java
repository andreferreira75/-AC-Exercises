import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Grid {


    MyFilePrinter myFilePrinter = new MyFilePrinter(this);

    private int cols;
    private int rows;
    public static final int CELLSIZE = 30;
    public static final int PADDING = 10;
    private final Rectangle[][] canvas;
    private final String[][] arrayFileTxt;

    private int col;
    private int row;

    public Grid(int cols, int rows) throws FileNotFoundException {
        this.cols = cols;
        this.rows = rows;
        canvas = new Rectangle[rows][cols];
        arrayFileTxt = new String[rows][cols];
        init();
    }


    //Initializer of the grid
    private void init(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Rectangle rectangle = new Rectangle((j * CELLSIZE) + PADDING, (i * CELLSIZE) + PADDING, CELLSIZE, CELLSIZE);
                    rectangle.draw();
                    arrayFileTxt[i][j] = "0";
                    canvas[i][j] = rectangle;


            }
        }

    }

    //Draws the grid that was saved
    public void drawGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (arrayFileTxt[i][j]){
                    case "0":
                        canvas[i][j].setColor(Color.BLACK);
                        canvas[i][j].draw();
                        break;

                    case "1":
                        canvas[i][j].setColor(Color.BLACK);
                        canvas[i][j].fill();
                        break;

                    case "2":
                        canvas[i][j].setColor(Color.BLUE);
                        canvas[i][j].fill();
                        break;

                    case "3":
                        canvas[i][j].setColor(Color.YELLOW);
                        canvas[i][j].fill();
                        break;

                    case "4":
                        canvas[i][j].setColor(Color.GREEN);
                        canvas[i][j].fill();
                        break;

                    case "5":
                        canvas[i][j].setColor(Color.RED);
                        canvas[i][j].fill();
                        break;

                    case "6":
                        canvas[i][j].setColor(Color.ORANGE);
                        canvas[i][j].fill();
                        break;
                }

            }

        }
    }


    public String getArrayFileTxt(int row, int col) {
        return arrayFileTxt[row][col];
    }


    public void setArrayFileTxt(int col, int row, String string){
           arrayFileTxt[row][col] = string;
    }


    public void setArrayFileTxtErase(int col, int row){
        arrayFileTxt[row][col] = "0";
    }


    public Rectangle getCanvas(int row, int col) {
        return canvas[row][col];
    }


    public int getCols() {
        return cols;
    }


    public int getRows() {
        return rows;
    }
}

