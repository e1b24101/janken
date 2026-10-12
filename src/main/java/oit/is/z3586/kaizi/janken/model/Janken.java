
package oit.is.z3586.kaizi.janken.model;

public class Janken {

  private String myHand;
  private String cpuHand;
  private String result;

  public Janken(String hand) {

    // CPUの手は常にグー
    cpuHand = "グー";

    // プレイヤーの手と勝敗を判定
    if (hand.equals("Gu")) {
      myHand = "グー";
      result = "あいこ";
    } else if (hand.equals("Choki")) {
      myHand = "チョキ";
      result = "負け";
    } else if (hand.equals("Pa")) {
      myHand = "パー";
      result = "勝ち";
    } else {
      myHand = "不明";
      result = "判定できません";
    }
  }

  public String getMyHand() {
    return myHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public String getResult() {
    return result;
  }
}
