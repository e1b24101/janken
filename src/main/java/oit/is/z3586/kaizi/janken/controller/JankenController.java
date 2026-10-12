
package oit.is.z3586.kaizi.janken.controller;

import oit.is.z3586.kaizi.janken.model.Janken;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  // Task 1：じゃんけん画面を表示
  @GetMapping("/janken")
  public String janken() {
    return "janken";
  }

  // Task 1：ユーザ名を受け取る
  @PostMapping("/janken")
  public String jankenPost(
      @RequestParam("username") String username,
      ModelMap model) {

    model.addAttribute("username", username);

    return "janken";
  }

  // Task 2：じゃんけんの対戦処理
  @GetMapping("/jankengame")
  public String jankenGame(
      @RequestParam("hand") String hand,
      ModelMap model) {

    Janken janken = new Janken(hand);

    model.addAttribute("myHand", janken.getMyHand());
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("result", janken.getResult());

    return "janken";
  }
}
