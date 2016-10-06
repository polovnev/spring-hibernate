<%@ tag body-content="tagdependent" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<div style="padding-left: 200px">
    City with the biggest length streets: <i id="sumLongestStreet"> </i><br>
    City with the biggest population: <i id="biggestPopulation"> </i><br>
    City with the smallest population: <i id="smallestPopulation"> </i><br>

    </br>
    <button id="send">send request</button>
</div>
<script>
    $(document).ready(function () {
        $("#send").click(function () {
            id = $("input:radio:checked").val();
            if (id == undefined) {
                alert("country not checked");
            } else {
                $.get("/city/sumLongestStreet?idCountry=" + id, function (data) {
                    $("#sumLongestStreet").text(data);
                });
                $.get("/city/biggestPopulation?idCountry=" + id, function (data) {
                    $("#biggestPopulation").text(data);
                });
                $.get("/city/smallestPopulation?idCountry=" + id, function (data) {
                    $("#smallestPopulation").text(data);
                });
            }
        });
    });
</script>
