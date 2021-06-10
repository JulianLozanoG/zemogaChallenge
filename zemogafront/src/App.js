import React, { Fragment } from "react";
import Formulario from "./components/Formulario";
import FormUpdate from "./components/FormUpdate";
import InitialPage from "./components/InitialPage";
import PortfolioStart from  "./components/PortfolioStart";

function App() {
  return (
    <Fragment>
      <InitialPage />
        <PortfolioStart/>
      <FormUpdate />
      <Formulario />
    </Fragment>
  );
}

export default App;
