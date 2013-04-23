<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/site/site.jsp" flush="true">
    <tiles:put name="nomeMenu" value="Home" />
    <tiles:put name="topo" value="/site/topo.jsp" />
    <tiles:put name="links" value="/site/links.jsp" />
    <tiles:put name="corpo" value="/site/home.jsp" />
    <tiles:put name="rodape" value="/site/rodape.jsp" />
    <tiles:put name="empresa" value="/site/empresa.jsp" />
    <tiles:put name="galeria" value="/site/galeria.jsp" />
</tiles:insert>