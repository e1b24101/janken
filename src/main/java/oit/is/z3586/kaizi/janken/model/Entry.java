
package oit.is.z3586.kaizi.janken.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Entry {

  // エントリーしているユーザー一覧
  private final List<String> users = new ArrayList<>();

  // ユーザーをエントリーに追加
  public synchronized void addUser(String username) {
    if (!users.contains(username)) {
      users.add(username);
    }
  }

  // エントリーしているユーザー一覧を取得
  public synchronized List<String> getUsers() {
    return new ArrayList<>(users);
  }
}
