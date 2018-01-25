	Parser Allegro to narzedzie sluzace do obrobki formularzy zakupow przesylanych przez allegro.pl po dokonaniu 
zakupu, oraz wybraniu sposobu platnosci i formy dostawy. 

	Testowe pliki w katalogu resources to autentyczne formularze
skopiowane z e-maila sprzedajacego(podmieniono w nich dane osobowe).
Aby z niego skorzystac - w klasie Parser Screen, w metodzie facade(), nalezy podac sciezke do pliku oraz nazwe, 
w formacie ods,csv itd. Nastepnie uruchomic program z klasy Main i postepowac wedlug polecen w konsoli.
W pliku docelowym nalezy ustawic rozdzielanie kolumn znakiem pipeline.
	Z formularzy allegro, wyciagniete zostana wszystkie dane, niezbedne do zarzadzania sprzedaza, wraz z wartoscia 
sprzedanych przedmiotow, oraz kwota naleznego podatku (3,5% od przychodu, dla mikrodzialalnosci oplacajacej podatek
zryczaltowany), a takze zsumowac i zapisac w pliku naleznosc podatku z wybranego miesiaca. 
Pole statusu platnosci, nalezy zweryfikowac samodzielnie - w zaleznosci od sposobu platnosci.

	W dalszej fazie rozwoju, program pozwoli uzytkownikowi zdefiniowac nazwe aukcji(i skrocony opis w pliku docelowym),
sciezke do pliku, oraz stawke podatku odpowiednia dla konkretnego rodzaju dzialalnosci.