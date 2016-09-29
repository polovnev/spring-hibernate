<%@ tag body-content="tagdependent" %>
<%@ attribute name="idCountry" required="true" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    $(document).ready(function(){

        $("button").click(function() {
            $.get("/goodResult?idCountry=${idCountry}", function(data){
                $("<span>data<span>").insertAfter(this);
                alert(data);
            });
        });
    });
</script>
