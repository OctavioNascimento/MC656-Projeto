import { render, screen } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import ErrorPage from "./ErrorPage";

test('Should render a button with text "LOGIN"', () => {
  render(
    <MemoryRouter>
      <ErrorPage />
    </MemoryRouter>
  );
  expect(
    screen.getByText(
      "Erro ao Carregar Página"
    )
  ).toBeInTheDocument();
});
