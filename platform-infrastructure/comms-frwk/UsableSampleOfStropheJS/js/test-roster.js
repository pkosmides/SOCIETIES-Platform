var Roster = {
		onRoster: function(items) {
			Controler.log("Roster IQ result", items);
			Controler.addToRoster('<ul>');
			$(items).each(function () {
				var jid = $(this).attr('jid');
				var name = $(this).attr('name') || jid;
				var e = $("<li id='" + jid + "'>"+
						"<span class='roster-name'>"+name+"</span>"+
						" <span class='roster-jid'>("+jid+")</span>"+
						"</li>");
				Controler.addToRoster(e.html());
			});
			Controler.addToRoster('</ul>');
		},

		start: function() {
			Controler.log("Get roster");
			Client.connection.roster.registerCallback(Roster.onRoster);
			Controler.log("Callback resitered");
			Client.connection.roster.get(Roster.onRoster);
			Controler.log("Groups: "+Client.connection.roster.items.groups);
			
//			var NS_IQ_ROSTER = 'jabber:iq:roster';
//			var iq = $iq({type: 'get'}).c('query', {xmlns: NS_IQ_ROSTER});
//			Client.connection.sendIQ(iq, Roster.onRoster);
//			Controler.connection.addHandler(Controler.on_roster_updated, NS_IQ_ROSTER, 'iq', 'set');
		}
}
