void main() {
    Scanner input = new Scanner(System.in);
    int money = 1000;
    int playerWin = 0;
    int houseWin = 0;
    int deckSize = 4;
    double wagered = 0;
    int blackjackPayout = 1; //1 betyder 3:2 som er den normale, 2 betyder 6:5 som nogle casioner tilbyder, denne variabel kunne have været en boolean
    boolean hitSoft17 = false;
    runMenu(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
}

static void runGame() {

}

static void runMenu(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    printMenu();
    int menuChoice = input.nextInt();
    if (menuChoice == 4) {
        System.exit(0);
    } else if (menuChoice == 3) {
        runSettings(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (menuChoice == 2) {
        runStats(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (menuChoice == 1) {
      //runGame
    }
}

static void runSettings(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    printSettings(money);
    int settingsChoice = input.nextInt();
    if (settingsChoice == 5) {
        runMenu(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (settingsChoice == 1) {
        changeBalance(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (settingsChoice == 2) {
        changeDeckSize(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (settingsChoice == 3) {
        changeBJPayout(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else if (settingsChoice == 4) {
        changeSoft17(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    }
}

static void changeSoft17(Scanner input, int moeny, int playerwin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    if (hitSoft17) {
        System.out.println("Lige nu tager dealer et kort mere, hvis han har blød 17");
    } else {
        System.out.println("Lige nu står dealer, hvis han har blød 17");
    }
    System.out.println("Skal han trække et kort mere på blød 17");
    System.out.println("1. Ja");
    System.out.println("2. Nej");
    System.out.println();
    System.out.print("Indtast her: ");
    int soft17Choice = input.nextInt();
    if (soft17Choice == 1) {
        hitSoft17 = true;
    } else if (soft17Choice == 2) {
        hitSoft17 = false;
    } else {
        System.out.println("Ugyldigt svar, defaulter til nej");
        hitSoft17 = false;
    }
    runSettings(input, moeny, playerwin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
}

static void printSettings(int money) {
    System.out.println("Settings:");
    System.out.println("1. Ændre saldo (" + money + " kr.)");
    System.out.println("2. Vælg antal kortspil i spil");
    System.out.println("3. Ændre blackjack payout");
    System.out.println("4. Dealer hit on soft 17?");
    System.out.println("5. Tilbage til menu");
    System.out.println();
    System.out.print("Indtast her: ");
}

static void printStats(int money, int playerWin, int houseWin, double wagered) {
    System.out.println("Stats:");
    System.out.println("Antal hænder du har vundet   : " + playerWin);
    System.out.println("Antal hænder huset har vundet: " + houseWin);
    System.out.println("Din saldo: " + money + " kr.");
    System.out.println("Total wagered: " + wagered + " kr.");
    System.out.println("1. Tilbage til menu");
    System.out.println();
    System.out.print("Indtast her: ");
}

static void changeBalance(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    System.out.println("Nuværende saldo: " + money);
    System.out.print("Indtast nye saldo: ");
    int newBalance = input.nextInt();
    money = newBalance;
    runSettings(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
}

static void runStats(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    printStats(money, playerWin, houseWin, wagered);
    int statsChoice = input.nextInt();
    if (statsChoice == 1) {
        runMenu(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    } else {
        runMenu(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
    }
}

static void changeDeckSize(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    System.out.println("Nuværende antal kortspil i spil: " + deckSize);
    System.out.println("Hvor mange kortspil vil du spille med?");
    System.out.println("Du kan vælge imellem 1-8");
    System.out.println();
    System.out.print("Indtast her: ");
    int newDeckSize = input.nextInt();
    if (newDeckSize < 1) {
        System.out.println("Kan ikke være mindre end 1, defualter til 4 antal kortspil");
        newDeckSize = 4;
    } else if (newDeckSize > 8) {
        System.out.println("Kan ikke være højere end 8, defualter til 4 antal kortspil");
        newDeckSize = 4;
    }
    deckSize = newDeckSize;
    runSettings(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
}

static void printMenu() {
    System.out.println("Menu:");
    System.out.println("1. Start");
    System.out.println("2. Stats");
    System.out.println("3. Settings");
    System.out.println("4. Slut");
    System.out.println();
    System.out.print("Indtast her: ");
}

static void changeBJPayout(Scanner input, int money, int playerWin, int houseWin, int deckSize, int blackjackPayout, boolean hitSoft17, double wagered) {
    String readable = "";
    if (blackjackPayout == 1) {
        readable = "3:2";
    } else if (blackjackPayout == 2) {
        readable = "6:5";
    }
    System.out.println("Nuværende blackjack payout: " + readable);
    System.out.println("Vælg mellem 3:2 eller 6:5");
    System.out.println("1. 3:2");
    System.out.println("2. 6:5");
    System.out.println();
    System.out.print("Indtast her: ");
    int payoutChoice = input.nextInt();
    if (payoutChoice < 1) {
        System.out.println("Ugyldigt svar, defaulter til 3:2");
        payoutChoice = 1;
    } else if (payoutChoice > 2) {
        System.out.println("Ugyldigt svar, defualter til 3:2");
        payoutChoice = 1;
    }
    blackjackPayout = payoutChoice;
    runSettings(input, money, playerWin, houseWin, deckSize, blackjackPayout, hitSoft17, wagered);
}