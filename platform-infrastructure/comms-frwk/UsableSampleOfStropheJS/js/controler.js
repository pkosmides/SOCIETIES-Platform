var Client = {
		jid: '',
		password: '',
		connection: null,
		show_raw: true,
		show_log: true,

		// log to console if available
		log: function (msg) {
			if (Client.show_log && window.console) { console.log(msg); }
		},

		// show the raw XMPP information coming in
		raw_input: function (data) {
			if (Client.show_raw) {
				Client.log('RECV: ' + data);
			}
		},

		// show the raw XMPP information going out
		raw_output: function (data) {
			if (Client.show_raw) {
				Client.log('SENT: ' + data);
			}
		},

		// simplify connection status messages
		feedback: function(msg, col) {
			$('#status').html(msg).css('color', col);
		},

		// decide what to do with an incoming message
		handle_update: function (data) {
			var _d = $(data);
			var _message = _d.html();
			var _type = _d.attr('type');

			switch (_type) {
			case MessageType.MSG_TEXT:
				Client.show_text(_message);
				break;
			case MessageType.MSG_HTML:
				Client.show_html(_message);
				break;
			default:
				Client.log("Oh dear! I don't understand");
			}
		},

		// inject text
		show_text: function (m) {
			$('#message').text(m);
		},

		// inject html
		show_html: function (m) {
			var e = document.createElement('div');
			e.innerHTML = m;
			$('#message').html(e.childNodes[0].nodeValue);
		},

		on_connect: function (status) {
			if (status == Strophe.Status.CONNECTING) {
				Client.log('Connecting...');
				Client.feedback('Connecting... (1 of 2)', '#009900');
			} else if (status == Strophe.Status.CONNFAIL) {
				Client.log('Failed to connect!');
				Client.feedback('Connection failed', '#FF0000');
			} else if (status == Strophe.Status.DISCONNECTING) {
				Client.log('Disconnecting...');
				Client.feedback('Disconnecting...', '#CC6600');
			} else if (status == Strophe.Status.DISCONNECTED) {
				Client.log('Disconnected');
				Client.feedback('Disconnected', '#aa0000');
			} else if (status == Strophe.Status.CONNECTED) {
				Client.log("Almost done...");
				Client.feedback('Connecting... (2 of 2)', '#009900');
				// Init
				Client.connection.send($pres().c('priority').t('-1'));
				
				// Modify UI
				Client.log("Connected");
				Client.feedback('Connected', '#009900');
			}
			return true;
		},
		
		on_disconnect: function() {
		},
};

$(document).ready(function () {
	// -- Init
	Client.feedback('Disconnected', '#aa0000');
	
	// -- If login action
	$('#connection').bind('click', function () {
		// Connection
		Client.jid = $('#jid').get(0).value;
		Client.password = $('#password').get(0).value;
		var conn = new Strophe.Connection(Config.BOSH_SERVICE);
		Client.connection = conn;
		Client.connection.rawInput = Client.raw_input;
		Client.connection.rawOutput = Client.raw_output;
		Client.connection.connect(
				Client.jid,
				Client.password,
				Client.on_connect,
				Client.on_connect_error
		);
		return false;
	});
	
	// -- If logout action
	$('#logout').live('click', function () {
		console.log('test');
		if (null != Client.connection) {
			Client.connection.disconnect();
		}
		Client.on_disconnect();
		return false;
	});
});
