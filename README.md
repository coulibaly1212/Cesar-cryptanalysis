# Cesar-cryptanalysis
cesar cryptanalyst with dictionary
Ce petit programme prend en entre un texte chiffre obtenu par le chiffrement de césar et de:

1- Cryptanalyse par l'analyse du nombre de répétition des lettres

	Exemple: cryptanalyse le texte suivant, en 6 essaie, et persiste sur une lettre de haute fréquence dans le Français 5 fois
	 	bien sur on peut les paramètres (nombre essaie, persiste sur une lettre de haute fréquence)

		Text a cryptanalyse : duc jlcm xo jicmmih yn uommc ohy vicmmih gucm duc jum jo fym guhayl ufilm dy fym uc lygcn

		[x=1, v=1, a=1, n=2, d=3, g=3, f=3, j=4, l=4, o=4, h=4, i=5, y=7, u=8, c=9, m=12] selon le cypherText


		
		Cryptanalyse selon la fréquence des lettre: 

		Essaie n° 1  	f(m)ct = 12,  f(e) = 15.9
		Si m -> e
		vmu bdue pg baueeaz qf mgeeu gzq naueeaz ymue vmu bme bg xqe ymzsqd mxade vq xqe mu dqyuf
		Remarque: pas de mot Français, même pas un seul

		

		Essaie n° 2 	f(c) selon ct = 9,  f(e) = 15.9
		si c -> e
		fwe lneo zq lkeookj ap wqooe qja xkeookj iweo fwe lwo lq hao iwjcan whkno fa hao we naiep
		Remarque: pas de mot Français

		Essaie n° 3 	f(u) selon ct = 8,  f(e) = 15.9
		Si u -> e
		nem tvmw hy tsmwwsr ix eywwm yri fsmwwsr qemw nem tew ty piw qerkiv epsvw ni piw em viqmx
		Remarque: pas de mot Français


		Essaie n° 4	f(y) selon ct = 7,  f(e) = 15.9     j'ai essaye 5 fois la lettre qui la plus haute fréquence 
				alors je passe au suivant (essayer plusieurs permet de mieux couvrir l'étendue de la bonne réponse)
		Si y -> e
		jai pris du poisson et aussi une boisson mais jai pas pu les manger alors je les ai remit
		Remarque: présence de mots Français, beaucoup de mot

		
		Essaie n° 5	f(i) selon ct = 9,  f(a) = 9.4
		Si i -> a
		vmu bdue pg baueeaz qf mgeeu gzq naueeaz ymue vmu bme bg xqe ymzsqd mxade vq xqe mu dqyuf
		Remarque: pas de mot Français


		Essaie n° 6	f(h) selon ct = h,  f(a) = 9.4
		h -> a			
		wnv cevf qh cbvffba rg nhffv har obvffba znvf wnv cnf ch yrf znatre nybef wr yrf nv erzvg
		Remarque: pas de mot Français

2- Voir si le texte en clair contient des mots Français a l'aide d'un dictionnaire de 27 000 mot

		Compter les mots trouver dans le dictionnaire, multiplier le résultat par 100 diviser par le nombre de mot total
	
3- Trier selon les probabilités obtenues dans l'étape 2

		Essaie n° 4
		Essaie n° 1
		Essaie n° 2
		Essaie n° 3
		Essaie n° 4
		Essaie n° 5
		Essaie n° 6


Le dictionnaire utilise: Dictionnaire_academie_francaise_5eme_edition.pdf
