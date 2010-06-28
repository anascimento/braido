<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>
<script type="text/javascript">
	$(function() {		
		$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});		
	});
</script>
<input type="text" id="${id}" name="${id}" value="${value}" />
