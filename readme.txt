1) přehled všech záznamů (do prohlížeče)
	http://localhost:8080/services/Home/Work/L07/products

2) záznam dle id (do prohlížeče)
http://localhost:8080/services/Home/Work/L07/productOne/valueId

3) nový záznam (Restlet client: metoda POST) 
http://localhost:8080/services/Home/Work/L07/product
body např:
{"nameProduct":"Rádio", "productURI":"radio.html", "priceWithVAT":"121 Kč", "priceWithOutVAT":"100 Kč"}
{"nameProduct":"Televize", "productURI":"televize.html", "priceWithVAT":"240 Kč", "priceWithOutVAT":"200 Kč"}
{"nameProduct":"Pračka", "productURI":"pracka.html", "priceWithVAT":"9360 Kč", "priceWithOutVAT":"8000 Kč"}

4) zrušení záznamu (Restlet client: metoda DELETE):
http://localhost:8080/services/Home/Work/L07/product/valueId

5) update záznamu  (Restlet client: metoda PUT):
http://localhost:8080/services/Home/Work/L07/product/valueId
v {body} je nová hodnota PriceProduct

6) Volání papouška - v URI jsou 2 hodnoty (value1, value2), které jsou ve výsledku sečteny jako řetězce (implementováno ve vrstvě services):
Do prohlížeče zadat:
http://localhost:8080/services/Home/Work/L07/Papousek/Variable/value1/value2
