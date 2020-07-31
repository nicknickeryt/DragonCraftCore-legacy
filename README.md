# DragonCraftCore 3
Plugin na podstawowe elementy serwera dla DragonCraft (DCRFT.PL)

## Funkcje

• /pomoc dla graczy,
• cenzura na czacie,
• wiadomości cykliczne,
• wiadomości o zakupie ze sklepu z dźwiękiem,
• możliwość rozpoczęcia restartu/zatrzymiania/przeładowania/przerwy na serwerze w ciągu minuty,
• możliwość ogłoszenia wiadomości na czacie serwera,
• losowanie kolorów lub czegokolwiek innego,
• czyszczenie czatu.

## Konfiguracja

### Domyślny plik konfiguracyjny

```
#╭━━━╮╱╱╱╱╱╱╱╱╱╱╱╱╱╭━━━╮╱╱╱╱╱╭━┳╮╭━━━╮
#╰╮╭╮┃╱╱╱╱╱╱╱╱╱╱╱╱╱┃╭━╮┃╱╱╱╱╱┃╭╯╰┫╭━╮┃
#╱┃┃┃┣━┳━━┳━━┳━━┳━╮┃┃╱╰╋━┳━━┳╯╰╮╭┫┃╱╰╋━━┳━┳━━╮
#╱┃┃┃┃╭┫╭╮┃╭╮┃╭╮┃╭╮┫┃╱╭┫╭┫╭╮┣╮╭┫┃┃┃╱╭┫╭╮┃╭┫┃━┫
#╭╯╰╯┃┃┃╭╮┃╰╯┃╰╯┃┃┃┃╰━╯┃┃┃╭╮┃┃┃┃╰┫╰━╯┃╰╯┃┃┃┃━┫
#╰━━━┻╯╰╯╰┻━╮┣━━┻╯╰┻━━━┻╯╰╯╰╯╰╯╰━┻━━━┻━━┻╯╰━━╯
#╱╱╱╱╱╱╱╱╱╭━╯┃
#╱╱╱╱╱╱╱╱╱╰━━╯

#Pomoc - treść wiadomości po /pomoc

pomoc:
- '&e » &3Treść wiadomości pomocy'

#Przedrostek - wiadomość u góry, przed tekstem z /pomoc

przedrostek: '&e&lDragon&6&lCraft&e » &aPomoc'

#Cenzura, zamiana wiadomości na inne. Aby wiadomośc nie została w ogóle wysłana, użyj ''

filtry:
  kurwa: (ಠ益ಠ)
  
#Czyszczenie czatu - wiadomość o wyczyszczeniu czatu na czacie serwera
  
cc: '&e&lDragon&6&lCraft&e » &cCzat został wyczyszczony.'
  
#Losowanie - wiadomośc o losowaniu i ta po wylosowaniu.

losuje: '&e&lDragon&6&lCraft &e» &3Losuję...'

wylosowano: '&e&lDragon&6&lCraft &e» &aWylosowany kolor to: '

#Losowanie - ustawienia kolorów do losowania (lub czegokolwiek)

kolorki:
- '&fbiały'
- '&6pomarańczowy'
- '&2zielony'
- '&eżółty'
- '&dróżowy'
- '&8czarny'
- '&4czerwony'
- '&1niebieski'
- '&3morski'

#Przedrostek wiadomości ze sklepu

sklep: '&e&lDragon&6&lCraft &e» &6Sklep'

#Przedrostek wiadomości cyklicznych na czacie

przedrostekwiadomosci: '&e&lDragon&6&lCraft &e» '

#Odstęp czasu pomiędzy wiadomościami w sekundach

cooldown: 90

#Lista wiadomości

wiadomosci:
  - "&3Wszelkie potrzebne informacje znajdziesz na &e/info&3 oraz na &e/pomoc&3."
  - "&3Nasz serwer Discord: &ediscord.gg/7pPNbUU&3. Więcej pod &e/discord&3."
  - "&3Witamy na nowej, &eIV Edycji&3 &e&lDragon&6&lCraft &eSurvival&3!"
  - "&3Chcesz przenieść &erangę&3 na &enowe konto&3? Użyj &e/przeniesrange&3!"
  - "&eSmocze jaja&3 można zakupić na &eDCRFT.PL &3i &e/sklep&3. &3Mogą one też wypaść z &eagresywnych mobów&3."
  - "&3Strefa &b&lVIP&3 jest pod /&bvip&3, &5&lSVIP&3 pod /&5svip&3, &9&lMVIP&3 pod /&9mvip&3, a &6&lEVIP&3 pod /&6evip&3."
  - "&3Rangę &b&lVIP&3 można także zakupić na /spawn, a rangę + na /&bvip&3, /&5svip&3 i /&9mvip&3, /&6evip&3."
  - "&3Serwer zmienisz za pomocą &e/serwer&3."
  - "&3Jeśli potrzebujesz &epomocy&3, użyj komendy &e/pomoc&3 lub &e/info&3. W razie potrzeby pomocy nie znajdującej się pod &e/pomoc&3, zgłoś się do &eaktywnych &3osób z &eadministracji&3 na naszym serwerze &eDiscord&3."
  - "&3Wszelkie problemy i zgłoszenia zgłaszaj administracji na serwerze &eDiscord &3bądź poprzez &e/zglos treść zgłoszenia&3."
  - "&3Gracza łamiącego regulamin zgłosisz na naszym serwerze &eDiscord &3lub za pomocą komendy &e/zglos treść zgłoszenia&3."
  - "&3Zapraszamy na naszego &eFacebooka&3: &ehttp://fb.com/dcrft.pl&3."
  - "&3Polub nas na &ewww.topkamc.pl/server/grOWQQqb&3."
  - "&3Zapraszamy na naszego &eInstagrama&3: &e@dcrft.pl&3."
  - "&3Chcesz przenieść &erangę&3 na &enowe konto&3? Użyj &e/przeniesrange&3!"
```

## Komendy i permisje
• /pomoc - wyświetla pomoc ustawioną w pliku konfiguracyjnym\
• /dcc <przeladuj>- główna komenda (dcc.adm)\
• /cc - czyści czat (cc.adm)\
• /losuj (panel.adm) - losuje z ustawionych wartości w pliku konfiguracyjnym (np. kolory)\
• /stop60, /reload60, /restart60, /przerwa60 (r.adm) - odpowiednio rozpoczyna zatrzymywanie serwera/przeładowanie plików serwera/restart serwera/ przerwę techniczną (biała lista + wyrzucenie graczy) w ciągu 1 minuty\
• /sklepbroadcast <gracz> <przedmiot> (r.adm) - informacja o zakupie ze sklepu, przydatne do ItemShopów\
• /sklepbroadcastdonate <gracz> <tekst> (r.adm) - informacja o dotacji ze sklepu, przydatne do ItemShopów\
• /dcccast <tekst> (dcc.adm) - dowolna informacja na czacie serwera
