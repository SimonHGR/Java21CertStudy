package s3progflow;

public class E2ExpressionSwitch {
  public static void main(String[] args) {
    String s = "Hello";

    switch (s) {
      case "Goodbye" -> {
        System.out.println("Au revoir");
        if (Math.random() > 0.5) break;
        System.out.println("nope");
      }
      case "Hello", "Guten Tag" -> System.out.println("Bonjour");
    }

    var result = switch (s) {
      case "Goodbye" -> "Au revoir";
      case "Hello" -> "Bonjour";
      default -> "Pardon?"; // must cover all input possibilities
    };

    enum Suit {
      HEART, DIAMOND, SPADE, CLUB;
    }

    Suit card = Suit.CLUB;
    // enums are easier to cover all input possibilities
    System.out.println(switch (card) {
      case CLUB, SPADE -> "Black"; // alternation using commas (only for constants)
      // qualified form permitted now (required if switch expression is not of the enum type!)
      case Suit.DIAMOND, Suit.HEART -> "Red";
    });

    card = Suit.HEART;
    String msg = switch (card) {
      case HEART -> { // RHS of -> must be a single "statement expression", or a block with yield in it
        System.out.println("Hmm, looks like a good card!");
        if (Math.random() > 0.5)
          yield "Your card is trumps";
        System.out.println("oops");
        yield "Whatever!!!";
      }
      default -> "Sorry, that suit is not trumps";
    };

    System.out.println("-----------------------");
    System.out.println(switch (card) {
      case HEART: // RHS of : must use yield
        System.out.println("Hmm, looks like a good card!");
//        yield "Your card is trumps"; // without yield, fallthough still happens in colon case
      default:
        System.out.println("Nah, not looking good from here");
        yield "Sorry, that suit is not trumps";
    });


  }
}
