1) přehled všech záznamů (do prohlížeče)
http://localhost:8080/services/Home/Work/L07/products

2) záznam dle id
http://localhost:8080/services/Home/Work/L07/productOne/valueId

3) nový záznam: 
http://localhost:8080/services/Home/Work/L07/product
{"nameProduct":"Rádio", "productURI":"radio.html", "priceWithVAT":"121 Kč", "priceWithOutVAT":"100 Kč"}
{"nameProduct":"Televize", "productURI":"televize.html", "priceWithVAT":"240 Kč", "priceWithOutVAT":"200 Kč"}
{"nameProduct":"Pračka", "productURI":"pracka.html", "priceWithVAT":"9360 Kč", "priceWithOutVAT":"8000 Kč"}

4) rušení záznamu:
http://localhost:8080/services/Home/Work/L07/product/valueId

5) update záznamu:
http://localhost:8080/services/Home/Work/L07/product/valueId
v {body}   je nová hodonota PriceProduct

6) navíc: Volání papouška - v URI jsou 2 proměnné, které jsouve vyýásledku sečteny jako řetězce (implementováno ve vrstvě services):
http://localhost:8080/services/Home/Work/L07/Papousek/Variable/value1/value2
