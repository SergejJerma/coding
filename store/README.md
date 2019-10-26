# Sandėlis

Sukurta prekių sandėlio informacinė sistema, kuri leidžia sandėlio administratoriui atlikti šiuos veiksmus:
●	Peržiūrėti trūkstamų prekių kiekius. 
●	Patikrinti prekes, kurių galiojimo laikas pasibaigęs arba pasibaigs greitu metu. 

## Programos klasės

* [Item.java](https://github.com/SergejJerma/coding/blob/master/store/src/main/java/com/serjer/Item.java) 
* [Store.java](https://github.com/SergejJerma/coding/blob/master/store/src/main/java/com/serjer/Store.java) 

## Paleidimas

Programa paleidžiama iš komandinės eilutės: 

```
C:\Users\User\Desktop\store>java -jar store.jar
```

Paleista programa nuskaito sample.csv failą, kuris turi būti padėtas
```
C:\Users\User\Desktop\store\sample.csv
```

## Trumpai apie veikimą

Paleista programa iš nuskaityto failo sudaro sandėlio prekių sąrašą, apjungiant dublikatus, jeigu prekės kodas, pavadinimas ir galiojimo data sutampa, atitinkamai sudeda kiekius. 
Konsolėje pateikiams meniu administratoriui:

```
Iveskite pagal ka norite tikrinti sandeli:
[1] - pagal prekiu likuti
[2] - pagal prekiu galiojimo data
[x] - baigti darba
```
Pasirinkus veiksmą, prašoma įvesti atitinkamus užklausos paramentrus:
```
Iveskite minimalu prekiu likuti
```
arba

```
Iveskite data prekiu galiojimui patikrinti
```
Programa kontroliuoja įvedamų parametrų formatą: prekių likutis turi būti skaičius, o galiojimo data įvesta yyyy-mm-dd formatu.

Tinkamai įvedus paramentrus, konsolėje pateikiami pagal prekių pavadinimus surušiuoti sąrašai.

Programa darbą baigią konsolėje įvedus [x].
