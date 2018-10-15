package controller;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class Test {
    public static void main(String... args){
        Game game = new Game();
        game.init();
        int stage = 0;
        for (int i = 0;; i++) {
            if (stage == 4) {
                game.showResult();
                return;
            }
            game.chooseOneTime(stage);
            stage = game.getNextStage(stage);
        }

    }
}
