
package oit.is.z3586.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken";
  }

  @PostMapping("/janken")
  public String jankenPost(
      @RequestParam("username") String username,
      ModelMap model) {

    model.addAttribute("username", username);

    return "janken";
  }
}
