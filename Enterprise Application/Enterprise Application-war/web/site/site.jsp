<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head>

<script type="text/javascript">
	var _siteRoot = 'index.html', _root = 'index.html';
</script>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jquery/scripts.js"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="jquery/jquery.ui.core.js"></script>
<script src="jquery/jquery.ui.widget.js"></script>
<script src="jquery/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="jquery/jquery.nivo.slider.js"></script>

<script type="text/javascript">
	function submitForm() {
		document.forms[0].action = "UserAction.do?method=add";
		document.forms[0].submit();
	}
</script>
<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#coin-slider').coinslider({
			width : 500,
			height : 313
		});
	});
</script>

<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<meta name="author" content="Phone2b" />

<meta http-equiv="X-UA-Compatible" content="IE=8" />

<script type="text/javascript" src="jquery/coin-slider.min.js"></script>

<link href="css/smart_cart.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery/jquery.smartCart-2.0.js"></script>

<link rel="shortcut icon" type="image/x-icon" href="images/logo.ico">
</head>

<link rel="stylesheet" href="css/coin-slider-styles.css" type="text/css" />

<link href="css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/styles.css" type="text/css"
	media="screen" />
<link rel="stylesheet" media="screen" type="text/css"
	href="css/android.css" />
<link rel="stylesheet" media="screen" type="text/css"
	href="css/default.css" />
<link rel="stylesheet" media="screen" type="text/css"
	href="css/layout.css" />
<link rel="stylesheet" href="css/jquery.ui.all.css">
<link rel="stylesheet" href="css/demos.css">




<body>

<div id="paginaTot" >
	<div id="body" >
		<tiles:insert attribute="topo" ignore="true" />
	</div>
	<div class="clear"></div>
	<ul id="menu">
		<tiles:insert attribute="links" ignore="true" />
	</ul>



	<div class="clear"></div>
	<div id="content">
		<div id="left">
				<br>
				
		 <html:form action="/UserAction" >
            Usuário : <html:text name="UserForm" property="email" /> <br>
            Senha  : <html:password name="UserForm" property="senha" /> <br>
            <html:submit value="Login" />
        </html:form>

			<div id='coin-slider'>
				<a href="UserAction.do?method=hidrat"> <img
					src='images/pendrive.jpg' />
				</a> <a href="UserAction.do?method=hidrat"> <img
					src='images/camera.jpg' />
				</a> <a href="UserAction.do?method=hidrat"> <img
					src='images/sonyvaio.jpg' />
				</a> <a href="UserAction.do?method=hidrat"> <img
					src='images/mp4.jpg' />
				</a>
			</div>
			
			<div>
				<h1 align="center">Calend&aacute;rio</h1>

				<div class="demo">
					<div id="datepicker"></div>
				</div>
			</div>
			
		</div>
	</div>
	<div id="right">
		<tiles:insert attribute="corpo" ignore="true" />
		<div id="block_left">
		</div>
		<div id="block_right">
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
	<div id="footer">
		<tiles:insert attribute="rodape" ignore="true" />
	</div>
</div>
 
</body>
</html>
</html>