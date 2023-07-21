import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.io.IOException;

public class Handler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    public Keyboard keyboard;
    public Player player;

    public Handler(Player player){
        this.player = player;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
               player.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
               player.moveLeft();
                break;

            case KeyboardEvent.KEY_UP:
               player.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
               player.moveDown();
                break;

            case KeyboardEvent.KEY_C:
                player.clear();
                player.setCleaning(true);
                break;

            case KeyboardEvent.KEY_SPACE:
                player.setPainting(true);
                player.paint();
                break;

            case KeyboardEvent.KEY_1:
                    player.setCurrentColor(Color.BLACK);
                    player.setCodeOfCurrentColor("1");
                    break;

            case KeyboardEvent.KEY_2:
                player.setCurrentColor(Color.BLUE);
                player.setCodeOfCurrentColor("2");
                break;

            case KeyboardEvent.KEY_3:
                player.setCurrentColor(Color.YELLOW);
                player.setCodeOfCurrentColor("3");
                break;

            case KeyboardEvent.KEY_4:
                player.setCurrentColor(Color.GREEN);
                player.setCodeOfCurrentColor("4");
                break;

            case KeyboardEvent.KEY_5:
                player.setCurrentColor(Color.RED);
                player.setCodeOfCurrentColor("5");
                break;

            case KeyboardEvent.KEY_6:
                player.setCurrentColor(Color.ORANGE);
                player.setCodeOfCurrentColor("6");
                break;

            case KeyboardEvent.KEY_S:
                player.save();
                break;

            case KeyboardEvent.KEY_L:
                player.load();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                player.setPainting(false);

            case KeyboardEvent.KEY_C:
                player.setCleaning(false);
        }
    }


    public void createKeyboardEvents(){
        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(paint);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(moveDown);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(load);

        KeyboardEvent continuousPainting = new KeyboardEvent();
        continuousPainting.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        continuousPainting.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(continuousPainting);

        KeyboardEvent continuousCleaning = new KeyboardEvent();
        continuousCleaning.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        continuousCleaning.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(continuousCleaning);

        KeyboardEvent setPaintBlack = new KeyboardEvent();
        setPaintBlack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintBlack.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(setPaintBlack);

        KeyboardEvent setPaintBlue = new KeyboardEvent();
        setPaintBlue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintBlue.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(setPaintBlue);

        KeyboardEvent setPaintYellow = new KeyboardEvent();
        setPaintYellow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintYellow.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(setPaintYellow);

        KeyboardEvent setPaintGreen = new KeyboardEvent();
        setPaintGreen.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintGreen.setKey(KeyboardEvent.KEY_4);
        keyboard.addEventListener(setPaintGreen);

        KeyboardEvent setPaintRed = new KeyboardEvent();
        setPaintRed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintRed.setKey(KeyboardEvent.KEY_5);
        keyboard.addEventListener(setPaintRed);

        KeyboardEvent setPaintOrange = new KeyboardEvent();
        setPaintOrange.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        setPaintOrange.setKey(KeyboardEvent.KEY_6 );
        keyboard.addEventListener(setPaintOrange);
        
    }

}
