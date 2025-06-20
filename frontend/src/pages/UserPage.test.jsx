import { render, screen } from '@testing-library/react'
import { MemoryRouter } from 'react-router-dom';
import UserPage from './UserPage';

test('Should render a input with a text "Informações gerais"', () => {
  render(
    <MemoryRouter>
      <UserPage />
    </MemoryRouter>
  )
  expect(screen.getByText('Informações gerais')).toBeInTheDocument();
})