package views;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class UiMessages {
  public static boolean askFoodYouLike(){
    JLabel label = new JLabel("Pense em um prato que gosta");
    label.setHorizontalAlignment(SwingConstants.CENTER);

    int answer = JOptionPane.showOptionDialog(null,
        label,
        "Jogo Gourmet",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        null,
        null);

    return answer != JOptionPane.DEFAULT_OPTION;
  }

  public static boolean askWhatYouThoughtAbout(String value){
    int answer = JOptionPane.showConfirmDialog(null,
        String.format("O prato que você pensou é %s ?", value),
        "Confirm",
        JOptionPane.YES_NO_OPTION);

    return answer == JOptionPane.YES_OPTION;
  }

  public static void sayHitAgain(){
    JOptionPane.showMessageDialog(
        null,
        "Acertei de novo");
  }

  public static String askFood(){
    return JOptionPane.showInputDialog("Qual prato você pensou?");
  }

  public static String askHint(String food, String value){
    return JOptionPane.showInputDialog(food + " é _____ mas " + value + " não.");
  }


}
