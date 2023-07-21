import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


import java.io.FileNotFoundException;
import java.io.IOException;


public class Player {

    private boolean isPainting = false;

    private boolean isCleaning = false;

    MyFilePrinter myFilePrinter;

    private final Rectangle player;

    private Color currentColor = Color.BLACK;

    private String codeOfCurrentColor = "1";
    Grid grid;
    private int col;
    private int row;


    public Player(int col, int row, Grid grid) throws FileNotFoundException {
        this.grid = grid;
        this.col = col;
        this.row = row;
        player = new Rectangle(col * Grid.CELLSIZE+ Grid.PADDING, row * Grid.CELLSIZE + Grid.PADDING,Grid.CELLSIZE, Grid.CELLSIZE);
        player.draw();
        player.setColor(Color.DARK_GRAY);
        player.fill();
        new Handler(this);
        myFilePrinter = new MyFilePrinter(grid);
    }

    //Fill character;
    public void fill(){
        player.fill();
    }

    //Method that is invoked when Right Arrow Key  is pressed
    public void moveRight(){
        if(col < grid.getCols() - 1){
        player.translate(Grid.CELLSIZE,0);
        col += 1;
        }
        if(isPainting) {
            paint();
        }
        if(isCleaning){
            clear();
        }
    }

    //Method that is invoked when Left Arrow Key  is pressed
    public void moveLeft(){
        if(col > 0){
        player.translate(-Grid.CELLSIZE, 0);
        col -= 1;
        }
        if(isPainting) {
            paint();
        }
        if(isCleaning){
            clear();
        }
    }


    //Method that is invoked when Up Arrow Key  is pressed
    public void moveUp(){
        if(row > 0){
        player.translate(0,-Grid.CELLSIZE);
        row -= 1;
        }
        if(isPainting) {
            paint();
        }
        if(isCleaning){
            clear();
        }
    }


    //Method that is invoked when Down Arrow Key  is pressed
    public void moveDown(){
        if(row < grid.getRows() - 1){
        player.translate( 0, Grid.CELLSIZE);
        row += 1;
        }
        if(isPainting){
            paint();
        }
        if(isCleaning){
            clear();
        }
    }

    //Color that is currently selected
    public void setCurrentColor(Color color){
        currentColor = color;
    }

    //Code of the color currently selected
    public void setCodeOfCurrentColor(String codeOfCurrentColor){
        this.codeOfCurrentColor = codeOfCurrentColor;
    }

    //Method that is invoked when spacebar is pressed
    public void paint() {
        if(isPainting){
            Rectangle paintRectangle = grid.getCanvas(row, col);
            grid.setArrayFileTxt(col, row, codeOfCurrentColor);
            System.out.println(currentColor);
            paintRectangle.setColor(currentColor);
            paintRectangle.fill();
        }
    }

    //Method that is invoked when Key-C is pressed
    public void clear(){
        Rectangle eraseRectangle = grid.getCanvas(row,col);
        grid.setArrayFileTxtErase(col, row);
        eraseRectangle.setColor(Color.BLACK);
        eraseRectangle.draw();

    }

    //Method that is invoked when Key-S is pressed
    public void save() {
        try {
            myFilePrinter.save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Method that is invoked when Key-L is pressed
    public void load() {
        try {
            myFilePrinter.loadFile("Resources/save.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        grid.drawGrid();
    }


    public void setCleaning(boolean cleaning) {
        this.isCleaning = cleaning;
    }


    public void setPainting(boolean painting) {
        this.isPainting = painting;
    }
}
