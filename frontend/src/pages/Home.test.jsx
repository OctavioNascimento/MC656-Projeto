import { render, screen } from '@testing-library/react'
import Home from './Home'
import { MemoryRouter } from 'react-router-dom';

test('Should render a page with text "Fazer Check-in"', () => {
  render(
    <MemoryRouter>
      <Home />
    </MemoryRouter>
  )
  expect(screen.getByPlaceholderText('Fazer Check-in')).toBeInTheDocument();
})