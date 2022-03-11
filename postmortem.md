# Loggbok

Filip TE19 2022-03-11

## Inledning

Målet var att göra ett MVC loggboksprogram som kan spara och ladda loggböcker som objekt i filer, med något sätt att lägga till nya loggar i en view.

Jag jobbade först med att skapa LogEntry objektet och sen med modellen så att den kan spara och ladda objekt och testade det genom en controller klass.
Efter det så gjorde jag view och skapade actionlisteners utifrån den i controllern som kopplar ihop view och modellen.

## Bakgrund

LogEntry objektet innehåller information som createdAt, updatedAt, author och message och metoder för att hämta och ändra på dom.

Modellen innehåller save och load metoder som använder sig av filnamn och en lista med logentries för att spara och ladda logentries från en fil.

Controller är det man kör för att starta programmet, den startar modell och view, gör en JFrame från view som den visar och innehåller actionlisteners som den 
sätter på knapparna i view. Combobox AL visar den valda logentryns information när man väljer den. AddNew AL skapar ny logentry från view och skickar det till modell och view, 
modellen sparar och viewen visar. Update AL gör en ny entry med samma createdAt som den valda, byter ut entry i modellen och sparar, skickar också entry till view, 
två entries med samma createdAt räknas som en entry. 

View innehåller getFilename metod som frågar användaren med en filväljningsruta, showLogEntry metod som byter ut texten i textrutorna för att visa en viss logentry.
AddLogListItem metoden tar en entry och kollar om den redan finns i comboboxen och väljer utifrån det att antingen uppdatera en existerande eller att skapa en ny entry 
i comboboxen. UpdateLogList metoden tar bort alla objekt i comboboxen och byter ut dom mot en lista med entries.

## Positiva erfarenheter

Jag fick lära mig hur man använder Jcomboboxes och fick påminna mig själv om hur man gör en view med Java swing.

Det gick bra att debugga och hitta fel genom att printa saker vid vissa ställen och använda breakpoints så att man kan se vad som händer i koden steg för steg.

Det gick bra att spara och ladda även fast det var objekt som skulle sparas och det var inte allt för stora problem att använda MVC 
för att det har jag gjort så många gånger nu.

Jag planerade inte för mycket saker så jag hann göra både ett fungerande program och en uppdateringsfunktion.

Det går att göra viewen på flera olika sätt, t.ex. att man visar hela loggboken samtidigt i ett fönster eller som jag har, en combobox. Jag valde att 
använda en combobox för att det går att visa väldigt många loggar samtidigt, jag förstår hur det funkar och det blir inga problem med att fundera ut hur man 
ska lägga till fler textfält och sånt.

## Negativa erfarenheter

Jag hade problem med uppdateringsmetoden ett tag för att jag tänkte först att det skulle funka att ta bort alla entries i comboboxen och 
byta ut dom mot en ny lista med uppdaterade entries, men när jag testade det så blev det problem och jag fick något konstigt felmeddelande och comboboxen funkade inte. 
Så efter debugging så jag kunde hitta var problemet låg så gjorde jag en annan lösning som antingen lägger till ett nytt entry i comboboxen eller om det redan finns 
ett entry med exakt samma createdAt tid så modifierar den den redan existerande och byter ut meddelande, author och uppdateringsdatum, så att då behöver jag inte ta bort 
något objekt från comboboxen som var problemet från början. Men då vet jag inte hur det skulle gå till om jag ville lägga till en borttagningsfunktion.

MVC modellen blev inte jättebra för att jag kom nu på att skapandet av JFrame och packandet av den sker med content från view men JFramen är i controllern, 
när den borde ha legat i view. Om man vill ha t.ex. en command line view så blir det ju då problem om controllern förväntar sig att få en JPanel som den ska visa i ett fönster. 
Den enda som borde visa något är view. Men nu vet jag vad jag har gjort fel så det kommer därför inte hända igen.

## Sammanfattning

Fick lära mig
* JComboboxes, Java swing
* Bli bättre på debugging
* Vad som kan bli fel med MVC
* Planera lagom mycket
* Hitta andra lösningar på problem

Utvecklingsmöjligheterna är bra för att man kan lägga till mer funktioner som att visa createdAt datum i view eller man kanske kan lägga till en borttagningsfunktion. Men 
om man ska byta view så borde man nog också fixa problemet med controllern som jag skrev om innan.
