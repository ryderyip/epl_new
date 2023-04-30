<p>
    <label>Username:</label>
    <input type="text" name="username" value="${param.username}" class="form-control"/>
</p>
<p>
    <label>Name:</label>
    <input type="text" name="name" value="${param.name}" class="form-control"/>
</p>
<p>
    <label>Phone:</label>
    <input type="text" name="phone" value="${param.phone}" class="form-control"/>
</p>
<p>
    <label>Gender:</label>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="gender" id="mgender"
           value="male" ${param.gender == 'M' ? 'checked' : ''}/>
    <label class="form-check-label" for="mgender">Male</label>
</div>

<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="gender" id="fgender"
           value="female" ${param.gender == 'M' ? '' : 'checked'} />
    <label class="form-check-label" for="fgender">Female</label>
</div>
</p>
<p>
    <label>Email:</label>
    <input type="text" name="email" value="${param.email}" class="form-control"/>
</p>