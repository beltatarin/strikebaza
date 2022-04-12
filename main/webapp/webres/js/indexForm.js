			var homeBtn = document.getElementsById("home");
			var pravilaBtn = document.getElementsById("pravila");
			var novichkamBtn = document.getElementsById("novichkam");
		

			var home = document.getElementsByClassName("content");
			var pravila = document.getElementsByClassName("pravila");
			var novichkam = document.getElementsByClassName("novichkam");
			var market = document.getElementsByClassName("market");
			var kontakty = document.getElementsByClassName("kontakty");
			
			home.style.display="block";
			pravila.style.display="none";
			novichkam.style.display="none";
			function func() {
				
				home.style.display="block";
				pravila.style.display="none";
				novichkam.style.display="none";
			  };
			  pravilaBtn.onclick = function() {
				
					home.style.display="none";
					pravila.style.display="block";
					novichkam.style.display="none";
			  };
				novichkamBtn.onclick = function() {
					home.style.display="none";
					pravila.style.display="none";
					novichkam.style.display="block";
				};
			