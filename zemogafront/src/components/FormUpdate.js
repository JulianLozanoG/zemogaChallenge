import React from "react";

const FormUpdate = () => {
    return (
        <form>
            <div class="form-group">
                <label className="form-label">Name</label>
                <input type="text" className="form-control" id="name"/>
            </div>
            <div className="form-group">
                <label className="form-label">Experience</label>
                <textarea className="form-control" id="experience" rows="3"/>
            </div>
            <div class="form-group">
                <label>Image</label>
                <input type="file" className="form-control-file" id="image"/>
            </div>

            <button type="submit" className="btn btn-primary">Update</button>
        </form>
    )
}

export default FormUpdate;
