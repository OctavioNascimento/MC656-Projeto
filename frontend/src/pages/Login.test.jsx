import { render, screen } from "@testing-library/react";
import Login from "./Login";
import { MemoryRouter } from "react-router-dom";

test('Should render a button with text "LOGIN"', () => {
  render(
    <MemoryRouter>
      <Login />
    </MemoryRouter>
  );
  expect(
    screen.getByText(
      "Gerencie seu usuário e senha única, acessar o Portal da Senha UNICAMP"
    )
  ).toBeInTheDocument();
});
