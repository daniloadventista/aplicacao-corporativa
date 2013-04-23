<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<div id="welcome">
	<h1 align="center">Cadastre-se</h1>

	 <strong>Formulario: </strong> <br />

	<div class="container" style="height: 503px;">
		<div class="bodys">
                    
                    <html:form styleId="contactform" styleClass="rounded" action="/UserAction.do?method=contato">
				<h3>Cadastro cliente:</h3>
				
				<div class="field">
					<label for="email">Email:</label> <html:text name="UserForm"  property="email" styleClass="input" />
					<p class="hint">Digite seu Email!!!</p>
				</div>
				<div class="field">
					<label for="email">Senha:</label> <html:password name="UserForm"  property="senha"  styleClass="input" />
					<p class="hint">Digite sua senha!!!</p>
				</div>
                                 <div class="field">
					<label for="senha">Confirma senha:</label> <html:password name="UserForm"  property="senha"  styleClass="input" />
					<p class="hint">Confirme sua senha!!!</p>
				</div>
                                <div class="field">
					<label for="telefone">Telefone:</label> <html:text name="UserForm"  property="telefone" styleClass="input" />
					<p class="hint">Digite seu telefone!!!</p>
				</div>
                                <div class="field">
					<label for="endereco">Endereço:</label> <html:text name="UserForm"  property="endereco"  styleClass="input" />
					<p class="hint">Digite seu endereço!!!</p>
				</div>
                               

                                <html:submit styleClass="botao3d" value="Enviar" />
                    </html:form><br/>
			</div>
	</div>

	<div class="clear"></div>
	
</div>
